package de.codecentric.vue;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VueIndexHtmlController {

    private Resource indexResource;

    /**
     * Damit das Caching funktioniert müssen hier ClassPathResource Objekte zurückgegeben werden, ByteArrayResource und InputStreamResource funktionieren nicht, da hier die lastModified checks von Spring fehlschlagen.
     * @return index.html as Resource
     */
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public Resource loadIndexHtml() {
        synchronized (this) {
            if (indexResource == null)
                indexResource = new ClassPathResource("/static/index.html");
        }
        return indexResource;
    }

}
