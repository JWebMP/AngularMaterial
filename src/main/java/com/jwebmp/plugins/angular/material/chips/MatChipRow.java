package com.jwebmp.plugins.angular.material.chips;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;

import java.util.Set;

@NgImportReference(value = "MatChipsModule", reference = "@angular/material/chips")
public class MatChipRow extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents<?>, MatChipRow> implements
                                                                                                                     INgComponent<MatChipRow>,
                                                                                                                     MatChipsChildren
{
    @Override
    public Set<String> moduleImports()
    {
        Set<String> strings = INgComponent.super.moduleImports();
        strings.add("MatChipsModule");
        return strings;
    }

    public MatChipRow()
    {
        setTag("mat-chip-row");
    }
}
