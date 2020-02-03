package com.xm.api_mall.service;

import com.xm.comment_serialize.module.mall.bo.PddThemeBo;
import com.xm.comment_serialize.module.mall.bo.ProductCriteriaBo;
import com.xm.comment_serialize.module.mall.bo.ShareLinkBo;
import com.xm.comment_serialize.module.mall.entity.SmProductEntity;
import com.xm.comment_serialize.module.mall.vo.SmProductSimpleVo;
import com.xm.comment_serialize.module.user.entity.SuOrderEntity;
import com.xm.comment_serialize.module.user.entity.SuUserEntity;
import com.xm.comment_utils.mybatis.PageBean;

import java.util.Date;
import java.util.List;

public interface ProductApiService {

    /**
     * 查询商品接口
     * @param criteria
     * @return
     */
    public PageBean<SmProductEntity> getProductByCriteria(ProductCriteriaBo criteria) throws Exception;

    /**
     * 获取商品详情
     * @param goodsIds
     * @return
     */
    public List<SmProductEntity> details(List<String> goodsIds) throws Exception;

    /**
     * 获取单个商品详情
     * 内容更加丰富
     * @param goodsId
     * @return
     * @throws Exception
     */
    public SmProductEntity detail(String goodsId,String pid) throws Exception;


    /**
     * 获取商品简略信息
     * @param goodsId
     * @return
     * @throws Exception
     */
    public SmProductSimpleVo basicDetail(Long goodsId) throws Exception;

    /**
     * 获取商品购买信息
     * @param customParams
     * @param pId
     * @param goodsId
     * @return
     * @throws Exception
     */
    public ShareLinkBo getShareLink(String customParams,String pId, String goodsId,String couponId) throws Exception;

    /**
     * 生成推广位id
     */
    public String generatePid(Integer userId) throws Exception;

    /**
     * 获取系统时间
     * @return
     */
    public Date getTime() throws Exception;


    /**
     * 多多客获取爆款排行商品接口
     * @param type      :商品类型(1:热销榜,2:收益榜)
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    public PageBean<SmProductEntity> getTopGoodsList(Integer type,String pid,Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 获取主题推广类型
     * @return
     */
    public List<PddThemeBo> getThemeList() throws Exception;

    /**
     * 获取主题商品列表
     * @param themeId
     * @return
     */
    public PageBean<SmProductEntity> getThemeGoodsList(Integer themeId,String pid) throws Exception;


    /**
     * 获取运营频道商品
     * @param channelType
     * @return
     * @throws Exception
     */
    public PageBean<SmProductEntity> getRecommendGoodsList(String pid,Integer channelType,Integer pageNum,Integer pageSize) throws Exception;



}
