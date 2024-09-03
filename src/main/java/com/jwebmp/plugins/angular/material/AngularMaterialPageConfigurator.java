/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.angular.material;


import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.client.annotations.angularconfig.NgStyleSheet;
import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.base.angular.services.compiler.JWebMPTypeScriptCompiler;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import jakarta.validation.constraints.NotNull;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author GedMarc
 * @since 21 Feb 2017
 */
@SuppressWarnings({"WeakerAccess",
        "UnusedReturnValue",
        "unused"})
@PluginInformation(pluginName = "Angular Material",
                   pluginDescription = "Angular Material Web Components",
                   pluginUniqueName = "angular",
                   pluginVersion = "18.0.6",
                   pluginDependancyUniqueIDs = "angular-material",
                   pluginCategories = "angular,material, ui",
                   pluginGitUrl = "https://github.com/JWebMP/AngularMaterial",
                   pluginSourceUrl = "https://material.angular.io",
                   pluginWikiUrl = "https://github.com/JWebMP/AngularMaterial/wiki",
                   pluginOriginalHomepage = "https://material.angular.io",
                   pluginDownloadUrl = "https://angularjs.org/",
                   pluginIconImageUrl = "https://angularjs.org/img/AngularJS-large.png",
                   pluginIconUrl = "https://angularjs.org/img/AngularJS-large.png",
                   pluginLastUpdatedDate = "2024/07/03",
                   pluginStatus = PluginStatus.Planned,
                   pluginGroupId = "com.jwebmp.plugins.angular.material",
                   pluginArtifactId = "angular-material",
                   pluginModuleName = "com.jwebmp.core.angular.angular",
                   pluginSubtitle = ""
)
@Log
@TsDependency(value = "@angular/material", version = "^18.0.6")
@TsDependency(value = "@angular/animations", version = "^18.0.1")
@NgStyleSheet(value = "@angular/material/prebuilt-themes/azure-blue.css")
//@NgBootImportReference(value = "BrowserAnimationsModule", reference = "@angular/platform-browser/animations")
//@NgBootModuleImport("BrowserAnimationsModule")
public class AngularMaterialPageConfigurator
        implements IPageConfigurator<AngularMaterialPageConfigurator>
{
    /**
     * If this configurator is enabled
     */
    private static boolean enabled = true;
    /**
     * If the angular functionality is requires or not
     */
    private static boolean required;

    private Map<Page<?>, JWebMPTypeScriptCompiler> pageCompilers = new HashMap<>();
    private Set<String> assetLocations = new LinkedHashSet<>();

    /**
     * Configures the angular page
     */
    public AngularMaterialPageConfigurator()
    {
        //No config required
    }

    /**
     * Method isEnabled returns the enabled of this AngularAnimatedChangePageConfigurator object.
     * <p>
     * If this configurator is enabled
     *
     * @return the enabled (type boolean) of this AngularAnimatedChangePageConfigurator object.
     */
    public static boolean isEnabled()
    {
        return AngularMaterialPageConfigurator.enabled;
    }

    /**
     * Method setEnabled sets the enabled of this AngularAnimatedChangePageConfigurator object.
     * <p>
     * If this configurator is enabled
     *
     * @param mustEnable the enabled of this AngularAnimatedChangePageConfigurator object.
     */
    public static void setEnabled(boolean mustEnable)
    {
        AngularMaterialPageConfigurator.enabled = mustEnable;
    }

    /**
     * If the configurator is required
     *
     * @return If it is required to render
     */
    public static boolean isRequired()
    {
        return AngularMaterialPageConfigurator.required;
    }

    /**
     * Sets angular as a required component
     *
     * @param required If it is required to render
     */
    public static void setRequired(boolean required)
    {
        AngularMaterialPageConfigurator.required = required;
    }

    @NotNull
    @Override
    public IPage<?> configure(IPage<?> page)
    {
        ((Page) page).getHead()
                     .add(new Link<>("https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap").setTag("link")
                                                                                                                     .addAttribute("rel", "stylesheet"));
        ((Page) page).getHead()
                     .add(new Link<>("https://fonts.googleapis.com/icon?family=Material+Icons").setTag("link")
                                                                                               .addAttribute("rel", "stylesheet"));
        return page;
    }

    @Override
    public boolean enabled()
    {
        return AngularMaterialPageConfigurator.enabled;
    }

    @Override
    public Integer sortOrder()
    {
        return Integer.MAX_VALUE - 100;
    }

}
