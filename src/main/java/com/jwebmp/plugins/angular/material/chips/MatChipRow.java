package com.jwebmp.plugins.angular.material.chips;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;

import java.util.Set;

@NgImportReference(value = "MatChipsModule", reference = "@angular/material/chips")
@NgImportModule("MatChipsModule")
public class MatChipRow extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents<?>, MatChipRow> implements
        INgComponent<MatChipRow>,
        MatChipsChildren
{
    public MatChipRow()
    {
        setTag("mat-chip-row");
    }
}
