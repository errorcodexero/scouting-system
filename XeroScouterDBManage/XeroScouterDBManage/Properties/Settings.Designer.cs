﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace XeroScouterDBManage_Server.Properties {
    
    
    [global::System.Runtime.CompilerServices.CompilerGeneratedAttribute()]
    [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.VisualStudio.Editors.SettingsDesigner.SettingsSingleFileGenerator", "14.0.0.0")]
    internal sealed partial class Settings : global::System.Configuration.ApplicationSettingsBase {
        
        private static Settings defaultInstance = ((Settings)(global::System.Configuration.ApplicationSettingsBase.Synchronized(new Settings())));
        
        public static Settings Default {
            get {
                return defaultInstance;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("C:\\temp")]
        public string ExportPath {
            get {
                return ((string)(this["ExportPath"]));
            }
            set {
                this["ExportPath"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("C:\\temp")]
        public string ImportPath {
            get {
                return ((string)(this["ImportPath"]));
            }
            set {
                this["ImportPath"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("-1")]
        public long SeasonID {
            get {
                return ((long)(this["SeasonID"]));
            }
            set {
                this["SeasonID"] = value;
            }
        }
        
        [global::System.Configuration.ApplicationScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.SpecialSettingAttribute(global::System.Configuration.SpecialSetting.ConnectionString)]
        [global::System.Configuration.DefaultSettingValueAttribute("server=localhost;user id=ftsscout;password=ftsscouter;persistsecurityinfo=True;da" +
            "tabase=")]
        public string FTS_ConnectionString {
            get {
                return ((string)(this["FTS_ConnectionString"]));
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("-1")]
        public long CompetitionID {
            get {
                return ((long)(this["CompetitionID"]));
            }
            set {
                this["CompetitionID"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("scouting")]
        public string DatabaseName {
            get {
                return ((string)(this["DatabaseName"]));
            }
            set {
                this["DatabaseName"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("scouting_test")]
        public string TestDatabaseName {
            get {
                return ((string)(this["TestDatabaseName"]));
            }
            set {
                this["TestDatabaseName"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("localhost")]
        public string dbHost {
            get {
                return ((string)(this["dbHost"]));
            }
            set {
                this["dbHost"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("ftsscout")]
        public string dbUser {
            get {
                return ((string)(this["dbUser"]));
            }
            set {
                this["dbUser"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("ftsscouter")]
        public string dbPassword {
            get {
                return ((string)(this["dbPassword"]));
            }
            set {
                this["dbPassword"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("True")]
        public string dbPersistSecurity {
            get {
                return ((string)(this["dbPersistSecurity"]));
            }
            set {
                this["dbPersistSecurity"] = value;
            }
        }
        
        [global::System.Configuration.ApplicationScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.SpecialSettingAttribute(global::System.Configuration.SpecialSetting.ConnectionString)]
        [global::System.Configuration.DefaultSettingValueAttribute("server={0}; user id={1}; password={2};persistsecurityinfo={3};database={4};Conver" +
            "t Zero Datetime=True")]
        public string DBConnectionTemplate {
            get {
                return ((string)(this["DBConnectionTemplate"]));
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("True")]
        public bool TEST_MODE {
            get {
                return ((bool)(this["TEST_MODE"]));
            }
            set {
                this["TEST_MODE"] = value;
            }
        }
        
        [global::System.Configuration.UserScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("")]
        public string SYSTEM_UUID {
            get {
                return ((string)(this["SYSTEM_UUID"]));
            }
            set {
                this["SYSTEM_UUID"] = value;
            }
        }
        
        [global::System.Configuration.ApplicationScopedSettingAttribute()]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [global::System.Configuration.DefaultSettingValueAttribute("HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Cryptography")]
        public string MachineGuidRegistryKey {
            get {
                return ((string)(this["MachineGuidRegistryKey"]));
            }
        }
    }
}
