package com.jwebmp.plugins.angular.material.select;

import com.google.common.base.Strings;
import com.jwebmp.core.base.html.DivSimple;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatOption extends DivSimple<MatOption> implements MatSelectChildren
{
    private String value;

    public MatOption()
    {
        setTag("mat-option");
    }

    public MatOption(String text)
    {
        this();
        setText(text);
    }

    @Override
    public void init()
    {
        if (!Strings.isNullOrEmpty(value))
        {
            addAttribute("[value]", value);
        }
        super.init();
    }

}
