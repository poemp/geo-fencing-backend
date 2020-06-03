package org.poem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.poem.entity.TPolygons;
import org.poem.vo.PolygonsDetailVO;
import org.poem.vo.PolygonsExistsVO;


/**
 * <p>
 * 27-搜索热词 服务类
 * </p>
 *
 * @author sangfor
 * @since 2020-03-13
 */
public interface ITPolygonsService extends IService<TPolygons> {


    /**
     * 保存或者是更新
     * @param polygonsDetailVO
     */
    void saveOrUpdatePolygons(PolygonsDetailVO polygonsDetailVO);


    /**
     * 跟新详情
     * @param providerId
     * @return
     */
    PolygonsDetailVO getPolygonsById(Long providerId);


    /**
     * 是不是存在
     * @param polygonsExistsVO
     * @return
     */
    boolean existPolygons(PolygonsExistsVO polygonsExistsVO);

    /**
     * 删除区域
     * @param provider
     */
    void dropPolygon(Long provider);
}
