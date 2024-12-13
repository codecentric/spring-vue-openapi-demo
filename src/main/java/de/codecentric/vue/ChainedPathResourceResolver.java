package de.codecentric.vue;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import java.util.List;

/**
 * Class extending the default Spring Boot {@link PathResourceResolver} to allow it to be chained together with other
 * resource resolvers without needing to be the last one.
 */
public class ChainedPathResourceResolver extends PathResourceResolver {
    @Override
    protected Resource resolveResourceInternal(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
        Resource resource = super.resolveResourceInternal(request, requestPath, locations, chain);
        return resource == null ? chain.resolveResource(request, requestPath, locations) : resource;
    }
}
