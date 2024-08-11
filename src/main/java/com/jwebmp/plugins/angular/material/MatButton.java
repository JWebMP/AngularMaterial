package com.jwebmp.plugins.angular.material;

import com.google.common.base.Strings;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;

import java.util.Set;

@NgImportReference(value = "MatButtonModule", reference = "@angular/material/button")
public class MatButton extends DivSimple<MatButton> implements INgComponent<MatButton>
{
    public MatButton()
    {
        setTag("button");
        addAttribute("mat-button", "");
    }

    @Override
    public Set<String> importModules()
    {
        Set<String> strings = INgComponent.super.importModules();
        strings.add("MatButtonModule");
        return strings;
    }

    public MatButton setAsLink(String href, String target)
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
        return this;
    }

    public MatButton setRaised()
    {
        removeAttribute("mat-button");
        addAttribute("mat-raised-button", "");
        return this;
    }

    public MatButton setFlat()
    {
        removeAttribute("mat-button");
        addAttribute("mat-flat-button", "");
        return this;
    }

    public MatButton setStroked()
    {
        removeAttribute("mat-button");
        addAttribute("mat-stroked-button", "");
        return this;
    }

    public MatButton setIcon()
    {
        removeAttribute("mat-button");
        addAttribute("mat-icon-button", "");
        return this;
    }

    public MatButton setFab()
    {
        removeAttribute("mat-button");
        addAttribute("mat-fab", "");
        return this;
    }

    public MatButton setMiniFab()
    {
        removeAttribute("mat-button");
        addAttribute("mat-mini-fab", "");
        return this;
    }

    public MatButton addIcon(String text)
    {
        add(new MatIcon().setIcon(text));
        return this;
    }
}
