package org.poem.controller;


import io.swagger.annotations.Api;

import org.poem.service.ITPolygonsService;
import org.poem.vo.PolygonsDetailVO;
import org.poem.vo.PolygonsExistsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sangfor
 * @since 2020-03-13
 */
@Api(tags = {"Polygons"})
@RestController
@RequestMapping("/v1/polygons")
public class TPolygonsController {

    @Autowired
    private ITPolygonsService polygonsService;

    /**
     * 保存或者是更新
     *
     * @param polygonsDetailVO
     */
    @PostMapping("/saveOrUpdatePolygons")
    public void saveOrUpdatePolygons(@RequestBody PolygonsDetailVO polygonsDetailVO) {
        polygonsService.saveOrUpdatePolygons(polygonsDetailVO);
    }


    /**
     * 跟新详情
     *
     * @param providerId
     * @return
     */
    @GetMapping("/getPolygonsById")
    public PolygonsDetailVO getPolygonsById(Long providerId) {
        return polygonsService.getPolygonsById(providerId);
    }


    /**
     * 是不是存在
     *
     * @param polygonsExistsVO
     * @return
     */
    @PostMapping("/existPolygons")
    public boolean existPolygons(@RequestBody PolygonsExistsVO polygonsExistsVO) {
        return polygonsService.existPolygons(polygonsExistsVO);
    }

    /**
     * 是不是存在
     *
     * @param providerId
     * @return
     */
    @PostMapping("/dropPolygon/{providerId}")
    public void existPolygons(@PathVariable("providerId") Long providerId) {
        polygonsService.dropPolygon(providerId);
    }
}
