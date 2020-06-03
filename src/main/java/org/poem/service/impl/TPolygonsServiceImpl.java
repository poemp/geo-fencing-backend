package org.poem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.poem.entity.TPolygons;
import org.poem.mapper.TPolygonsMapper;
import org.poem.service.ITPolygonsService;
import org.poem.utils.InOrOutPolygonUtils;
import org.poem.utils.SnowFlake;
import org.poem.vo.PolygonsDetailVO;
import org.poem.vo.PolygonsExistsVO;
import org.poem.vo.PolygonsVO;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 27-搜索热词 服务实现类
 * </p>
 *
 * @author sangfor
 * @since 2020-03-13
 */
@Service
public class TPolygonsServiceImpl extends ServiceImpl<TPolygonsMapper, TPolygons> implements ITPolygonsService {


    /**
     *
     * @param polygonsDetailVO
     */
    @Override
    public void saveOrUpdatePolygons(PolygonsDetailVO polygonsDetailVO) {
        QueryWrapper<TPolygons> tPolygonsQueryWrapper = new QueryWrapper<>();
        tPolygonsQueryWrapper.lambda().eq(TPolygons::getProviderId, polygonsDetailVO.getProvider());
        this.remove(tPolygonsQueryWrapper);

        List<TPolygons> polygons = Lists.newArrayList();
        for (PolygonsVO polygonsVO : polygonsDetailVO.getPolygonsVOS()) {
            TPolygons tPolygons = new TPolygons();
            tPolygons.setCreateTime(LocalDateTime.now());
            tPolygons.setId(SnowFlake.genLongId());
            tPolygons.setLat(polygonsVO.getLat());
            tPolygons.setLng(polygonsVO.getLng());
            tPolygons.setP(polygonsVO.getP());
            tPolygons.setQ(polygonsVO.getQ());
            tPolygons.setProviderId(polygonsDetailVO.getProvider());
            polygons.add(tPolygons);
        }
        this.saveBatch(polygons);

    }

    /**
     *
     * @param providerId
     * @return
     */
    @Override
    public PolygonsDetailVO getPolygonsById(Long providerId) {
        QueryWrapper<TPolygons> tPolygonsQueryWrapper = new QueryWrapper<>();
        tPolygonsQueryWrapper.lambda().eq(TPolygons::getProviderId, providerId);
        List<TPolygons> polygons = list(tPolygonsQueryWrapper);
        PolygonsDetailVO vo = new PolygonsDetailVO();
        vo.setPolygonsVOS(polygons.parallelStream().map(
                o -> {
                    PolygonsVO polygonsVO = new PolygonsVO();
                    polygonsVO.setLat(o.getLat());
                    polygonsVO.setLng(o.getLng());
                    polygonsVO.setP(o.getP());
                    polygonsVO.setQ(o.getQ());
                    return polygonsVO;
                }
        ).collect(Collectors.toList()));
        return vo;
    }

    /**
     *
     * @param polygonsExistsVO
     * @return
     */
    @Override
    public boolean existPolygons(PolygonsExistsVO polygonsExistsVO) {
        QueryWrapper<TPolygons> tPolygonsQueryWrapper = new QueryWrapper<>();
        tPolygonsQueryWrapper.lambda().eq(TPolygons::getProviderId, polygonsExistsVO.getProviderId());
        List<TPolygons> polygons = list(tPolygonsQueryWrapper);
        Point2D.Double d1 = new Point2D.Double(polygonsExistsVO.getLat(), polygonsExistsVO.getLng());
        List<Point2D.Double> pts = polygons.parallelStream().map(
                o -> {
                    return new Point2D.Double(o.getLat(), o.getLng());
                }
        ).collect(Collectors.toList());
        return InOrOutPolygonUtils.IsPtInPoly(d1, pts);
    }
}
