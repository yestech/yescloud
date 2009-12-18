package org.yestech.cloud.controller;


import org.yestech.cloud.service.ISearchService;
import org.yestech.cloud.objectmodel.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

import com.googlecode.htmleasy.View;

/**
 * Allows the cloud to be viewed
 */
@Path("/")
@Service
public class ViewCloudController {
    private static Log logger = LogFactory.getLog(ViewCloudController.class);

    @Resource(name = "searchService")
    private ISearchService searchService;

    public void setSearchService(ISearchService searchService) {
        this.searchService = searchService;
    }

    @GET
    @Path("/")
    public View viewCloud() {
        //TODO:  load the public cloud...
        return new View("/WEB-INF/jsp/public.jsp");
    }

    @GET
    @Path("/retrieve/{key}")
    @Produces("application/json")
    public IViewableCloud retrieveCloud(@PathParam("key") String key, @Context HttpServletResponse response) throws IOException {
        IViewableCloud viewableCloud = new DefaultViewableCloud();
        if (StringUtils.isBlank(key)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            viewableCloud = searchService.viewCloud(key);
            if (logger.isInfoEnabled()) {
                logger.info(viewableCloud);
            }

        }
        return viewableCloud;
    }

    @GET
    @Path("/items/{key}/{tag}")
    @Produces("application/json")
    public List<CloudItem> viewCloudItems(@PathParam("key") String key, @PathParam("text") String text) {
        String userGuid = key;

        List<CloudItem> items = searchService.viewCloudItems(userGuid, text);
        if (logger.isInfoEnabled()) {
            logger.info(items);
        }
        return items;
    }

}
