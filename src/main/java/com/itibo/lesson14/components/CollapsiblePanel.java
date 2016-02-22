package com.itibo.lesson14.components;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UINamingContainer;

@ManagedBean
@SessionScoped
public class CollapsiblePanel extends UINamingContainer {

    private boolean collapsed = false;

    public boolean isCollapsed() {
        return collapsed;
    }
    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }
    public String toggle() {
        collapsed = !collapsed;
        return null;
    }
}
