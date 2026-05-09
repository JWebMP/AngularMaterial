package com.jwebmp.plugins.angular.material;

import com.google.common.base.Strings;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;

import java.util.Set;

@NgImportReference(value = "MatButtonModule", reference = "@angular/material/button")
@NgImportModule("MatButtonModule")
public class MatButton<J extends MatButton<J>> extends DivSimple<J> implements INgComponent<J>
{
    public MatButton()
    {
        setTag("button");
        addAttribute("mat-button", "");
    }
    
    @SuppressWarnings("unchecked")
    public J setAsLink(String href, String target)
    {
        setTag("a");
        if (!Strings.isNullOrEmpty(href))
        {
            addAttribute("href", href);
        }
        if (!Strings.isNullOrEmpty(target))
        {
            addAttribute("target", target);
        }
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setRaised()
    {
        removeAttribute("mat-button");
        addAttribute("mat-raised-button", "");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setFlat()
    {
        removeAttribute("mat-button");
        addAttribute("mat-flat-button", "");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setStroked()
    {
        removeAttribute("mat-button");
        addAttribute("mat-stroked-button", "");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setIcon()
    {
        removeAttribute("mat-button");
        addAttribute("mat-icon-button", "");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setFab()
    {
        removeAttribute("mat-button");
        addAttribute("mat-fab", "");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setMiniFab()
    {
        removeAttribute("mat-button");
        addAttribute("mat-mini-fab", "");
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J addIcon(String text)
    {
        add(new MatIcon<>().setIcon(text));
        return (J) this;
    }
}
