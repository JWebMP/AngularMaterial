import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.angular.material.AngularMaterialPageConfigurator;
import com.jwebmp.plugins.angular.material.implementations.AngularMaterialScanModule;

module com.jwebmp.plugins.angular.material {

    exports com.jwebmp.plugins.angular.material;
    exports com.jwebmp.plugins.angular.material.dialog;
    exports com.jwebmp.plugins.angular.material.formfield;
    exports com.jwebmp.plugins.angular.material.forms;
    exports com.jwebmp.plugins.angular.material.table;
    exports com.jwebmp.plugins.angular.material.accordion;
    exports com.jwebmp.plugins.angular.material.accordion.interfaces;
    exports com.jwebmp.plugins.angular.material.select;
    exports com.jwebmp.plugins.angular.material.checkbox;

    requires com.jwebmp.core;
    requires static lombok;
    requires com.jwebmp.client;
    requires com.jwebmp.core.angular;

    provides IGuiceScanModuleInclusions with AngularMaterialScanModule;
    provides IPageConfigurator with AngularMaterialPageConfigurator;

    opens com.jwebmp.plugins.angular.material to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.angular.material.implementations to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.angular.material.dialog to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.angular.material.formfield to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.angular.material.forms to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.angular.material.table to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.angular.material.accordion to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.angular.material.select to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;
    opens com.jwebmp.plugins.angular.material.checkbox to com.google.guice, com.jwebmp.core, com.fasterxml.jackson.databind;

}