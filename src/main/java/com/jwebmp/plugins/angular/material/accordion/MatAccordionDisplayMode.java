package com.jwebmp.plugins.angular.material.accordion;

public enum MatAccordionDisplayMode
{
    $default,
    flat;

    @Override
    public String toString()
    {
        return name().replace("$", "");
    }
}
