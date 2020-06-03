package org.poem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 27-搜索热词
 * </p>
 *
 * @author sangfor
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TPolygons implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户标签
     */
    private Long id;

    /**
     * 商户的id
     */
    private Long providerId;
    /**
     *
     */
    private Double P;

    /**
     *
     */
    private Double Q;

    /**
     * 经度
     */
    private Double lat;

    /**
     * 维度
     */
    private Double lng;

    /**
     * 新建时间
     */
    private LocalDateTime createTime;



}
