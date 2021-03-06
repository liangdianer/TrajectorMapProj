package com.stormphoenix.graduatedesign.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Developer on 18-5-10.
 */
@Controller
public class MapController {
    private Logger logger = LoggerFactory.getLogger(MapController.class);

    @RequestMapping(value = "/single_user_query", method = RequestMethod.GET)
    public String singleUserQuery() {
        return "trajector_map1";
    }

    @RequestMapping(value = "/muti_user_cut_query", method = RequestMethod.GET)
    public String trajectorMap() {
        return "trajector_map";
    }

    @RequestMapping(value = "/muti_user_cut_query_without_redis", method = RequestMethod.GET)
    public String multiUserQueryWithoutRedis() {
        return "trajector_map2";
    }
}
