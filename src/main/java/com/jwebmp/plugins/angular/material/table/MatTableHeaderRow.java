package com.jwebmp.plugins.angular.material.table;

import com.jwebmp.core.base.html.TableRow;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class MatTableHeaderRow extends TableRow<MatTableHeaderRow>
{
    public MatTableHeaderRow()
    {
        addAttribute("mat-header-row", "");
        addAttribute("*matHeaderRowDef", "displayedColumns");
    }
}
