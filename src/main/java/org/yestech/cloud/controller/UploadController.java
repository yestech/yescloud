/*
 * Copyright LGPL3
 * YES Technology Association
 * http://yestech.org
 *
 * http://www.opensource.org/licenses/lgpl-3.0.html
 */

package org.yestech.cloud.controller;


import org.yestech.cloud.service.ISearchService;
import org.yestech.cloud.objectmodel.*;
import static org.yestech.cloud.objectmodel.CloudFactory.create;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;

/**
 * Used when uploading an artifact to the cload
 */
@Path("/upload")
@Service
public class UploadController {
    private static Log logger = LogFactory.getLog(UploadController.class);

    @Resource(name = "searchService")
    private ISearchService searchService;

    public void setSearchService(ISearchService searchService) {
        this.searchService = searchService;
    }

    @PUT
    @Path("/text/{key}")
    public void postStream(@PathParam("key") String key, String content, @Context HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(content)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            ICloud<String> cloud = create(key, content);
            searchService.postCloudItem(cloud);
        }
    }
}