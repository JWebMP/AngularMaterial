package com.jwebmp.plugins.angular.material;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@NgImportReference(value = "MatIconModule", reference = "@angular/material/icon")
@NgImportModule("MatIconModule")
public class MatIcon<J extends MatIcon<J>> extends DivSimple<J> implements INgComponent<J>
{
    private String icon;

    public MatIcon()
    {
        setTag("mat-icon");
    }

    @SuppressWarnings("unchecked")
    public J setIcon(String icon)
    {
        this.icon = icon;
        return (J) this;
    }

    @Override
    protected void init()
    {
        setText(icon);
        super.init();
    }
}
