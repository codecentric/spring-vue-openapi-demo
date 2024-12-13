package de.codecentric.vue;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import jakarta.servlet.http.HttpServletRequest;

public class VueResourceResolver implements ResourceResolver {
    private static final Logger logger = LoggerFactory.getLogger(VueResourceResolver.class);

    private VueIndexHtmlController indexController;

    public VueResourceResolver(VueIndexHtmlController indexController) {
        this.indexController = indexController;
    }

    @Override
    public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
        logger.debug("Resolving resource {}", requestPath);
        return getResource();
    }

    @Override
    public String resolveUrlPath(String resourceUrlPath, List<? extends Resource> locations, ResourceResolverChain chain) {
        logger.debug("Resolving resource path {}", resourceUrlPath);
        return (StringUtils.hasText(resourceUrlPath) &&
                getResource() != null ? resourceUrlPath : null);
    }

    @Nullable
    private Resource getResource() {
        return indexController.loadIndexHtml();
    }
}
