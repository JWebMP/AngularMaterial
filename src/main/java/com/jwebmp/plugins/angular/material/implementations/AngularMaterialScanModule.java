package com.jwebmp.plugins.angular.material.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;

import java.util.Set;

public class AngularMaterialScanModule implements IGuiceScanModuleInclusions<AngularMaterialScanModule>
{
    @Override
    public Set<String> includeModules()
    {
        return Set.of("com.jwebmp.plugins.angular.material");
    }
}
