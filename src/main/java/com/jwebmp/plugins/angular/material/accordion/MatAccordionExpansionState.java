package com.jwebmp.plugins.angular.material.accordion;

public enum MatAccordionExpansionState
{
    expanded,
    collapsed;

    @Override
    public String toString()
    {
        return name().replace("$", "");
    }
}
