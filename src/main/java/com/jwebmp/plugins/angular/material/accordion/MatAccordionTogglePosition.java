package com.jwebmp.plugins.angular.material.accordion;

public enum MatAccordionTogglePosition
{
    before,
    after;

    @Override
    public String toString()
    {
        return name().replace("$", "");
    }
}
