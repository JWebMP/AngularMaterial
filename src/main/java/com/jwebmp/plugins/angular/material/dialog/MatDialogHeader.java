package com.jwebmp.plugins.angular.material.dialog;

import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.H1;
import com.jwebmp.plugins.angular.material.MatIcon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatDialogHeader extends DivSimple<MatDialogHeader>
{
    private MatIcon icon;
    private H1<?> title;

    public MatDialogHeader()
    {
        addClass("dialog-header");
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            if (icon != null)
            {
                add(icon);
            }
            if (title != null)
            {
                add(title);
            }
        }
        super.init();
    }
}
