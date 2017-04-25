
package com.taurusx.xsite.modules.sys.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taurusx.xsite.common.persistence.DataEntity;

/**
 * 菜单Entity
 * 
 * @author ThinkGem
 * @version 2013-05-15
 */
public class Menu extends DataEntity<Menu> {

    private static final long serialVersionUID = 1L;
    private Menu parent; // 父级菜单
    private String parentIds; // 所有父级编号
    private String name; // 名称
    private String href; // 链接
    private String target; // 目标（ mainFrame、_blank、_self、_parent、_top）
    private String icon; // 图标
    private Integer sort; // 排序
    private String isShow; // 是否在菜单中显示（1：显示；0：不显示）
    private String permission; // 权限标识

    private String userId;
    
    private String isFavorite = "0"; // 用户是否收藏此菜单（1：收藏，0：未收藏）
    private String isUsercenter = "0"; // 是否在个人中心下拉菜单显示

    public Menu() {
        super();
        this.sort = 30;
        this.isShow = "1";
    }

    public Menu(String id) {
        super(id);
    }

    @JsonBackReference
    @NotNull
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Length(min = 1, max = 2000)
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    @Length(min = 1, max = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 0, max = 2000)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Length(min = 0, max = 20)
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Length(min = 0, max = 100)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @NotNull
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Length(min = 1, max = 1)
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        if (null == isShow || isShow.trim().isEmpty()
                || "null".equalsIgnoreCase(isShow) || "0".equals(isShow)) {
            this.isShow = "0";
        } else {
            this.isShow = "1";
        }
        // this.isShow = isShow;
    }

    @Length(min = 0, max = 200)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getParentId() {
        return parent != null && parent.getId() != null ? parent.getId() : "0";
    }

    @JsonIgnore
    public static void sortList(List<Menu> list, List<Menu> sourcelist,
            String parentId, boolean cascade) {
        for (int i = 0; i < sourcelist.size(); i++) {
            Menu e = sourcelist.get(i);
            if (e.getParent() != null && e.getParent().getId() != null
                    && e.getParent().getId().equals(parentId)) {
                list.add(e);
                if (cascade) {
                    // 判断是否还有子节点, 有则继续获取子节点
                    for (int j = 0; j < sourcelist.size(); j++) {
                        Menu child = sourcelist.get(j);
                        if (child.getParent() != null
                                && child.getParent().getId() != null
                                && child.getParent().getId()
                                        .equals(e.getId())) {
                            sortList(list, sourcelist, e.getId(), true);
                            break;
                        }
                    }
                }
            }
        }
    }

    @JsonIgnore
    public static String getRootId() {
        return "1";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * 获取 isFavorite
     * 
     * @return the isFavorite
     */
    @Length(min = 1, max = 1)
    public String getIsFavorite() {
        return isFavorite;
    }

    /**
     * 设置 isFavorite
     * 
     * @param isFavorite the isFavorite to set
     */
    public void setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
    }

    /**
     * 获取 isUsercenter
     * 
     * @return the isUsercenter
     */
    @Length(min = 1, max = 1)
    public String getIsUsercenter() {
        return isUsercenter;
    }

    /**
     * 设置 isUsercenter
     * 
     * @param isUsercenter the isUsercenter to set
     */
    public void setIsUsercenter(String isUsercenter) {
        this.isUsercenter = isUsercenter;
    }
    
}