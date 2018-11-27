package com.liuzhiqiang.config.page;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 * <p>
 * 类功能描述
 *
 * @author 刘志强
 * @created 2018/3/28.
 */
public class PageHelper {
    public static void startPage(Pagination pagination) {
        if (pagination == null) {
            pagination = new Pagination();
        }
        com.github.pagehelper.PageHelper.startPage(pagination.getCurrent(),pagination.getPageSize());
    }

    /**
     * 不分页
     * @param pagination
     */
    public static void startPageNotCount(Pagination pagination) {
        if (pagination == null) {
            pagination = new Pagination();
        }
        com.github.pagehelper.PageHelper.startPage(pagination.getCurrent(),pagination.getPageSize(),false);
    }
}
