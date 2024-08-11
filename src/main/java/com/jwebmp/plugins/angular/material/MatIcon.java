package com.jwebmp.plugins.angular.material;

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
@NgImportReference(value = "MatIconModule", reference = "@angular/material/icon")
public class MatIcon extends DivSimple<MatIcon> implements INgComponent<MatIcon>
{
    private String icon;

    public MatIcon()
    {
        setTag("mat-icon");
    }

    @Override
    public void init()
    {
        setText(icon);
        super.init();
    }

    @Override
    public Set<String> importModules()
    {
        Set<String> strings = INgComponent.super.importModules();
        strings.add("MatIconModule");
        return strings;
    }

}
