package com.jwebmp.plugins.angular.material;

import com.google.common.base.Strings;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)

@NgImportReference(value = "MatProgressBarModule", reference = "@angular/material/progress-bar")
public class MatProgressBar extends DivSimple<MatProgressBar> implements INgComponent<MatProgressBar>
{
    private String bufferValue;
    private String value;
    private String color;
    private String mode;

    public MatProgressBar()
    {
        setTag("mat-progress-bar");
    }

    @Override
    public Set<String> importModules()
    {
        Set<String> strings = INgComponent.super.importModules();
        strings.add("MatProgressBarModule");
        return strings;
    }


    @Override
    public void init()
    {
        if (!Strings.isNullOrEmpty(mode))
        {
            addAttribute("[mode]", mode);
        }
        if ("buffer".equalsIgnoreCase(mode))
        {
            addAttribute("[mode]", "'buffer'");
        }
        if ("bufferValue".equalsIgnoreCase(bufferValue))
        {
            addAttribute("[bufferValue]", bufferValue);
        }
        if ("value".equalsIgnoreCase(value))
        {
            addAttribute("[value]", value);
        }
        if ("color".equalsIgnoreCase(color))
        {
            addAttribute("[color]", color);
        }
        super.init();
    }
}
