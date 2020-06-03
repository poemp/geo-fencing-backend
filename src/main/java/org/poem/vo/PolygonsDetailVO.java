package org.poem.vo;

import lombok.Data;

import java.util.List;

@Data
public class PolygonsDetailVO {

    private Long provider;

    private List<PolygonsVO> polygonsVOS;

}
