/*
  specify which libraries to load: 
    In the Governance Tier configuration file, 
    these should be configurations common across 
    all apps governed by this config. 
    
    allow_scm_jenkinsfile = false
skip_default_checkout = false
keywords{
    master = '^[Mm]aster$'
    develop = '^[Dd]evelop(ment|er|)$'
    hotfix = '^[Hh]ot[Ff]ix-'
    release = '^[Rr]elease-(\\d+.)*\\d$'
}
template_methods{
    unit_test{}
    static_code_analysis{}
    build{}
    scan_container_image{}
    penetration_test{}
    accessibility_compliance_test{}
    performance_test{}
    functional_test{}
}
steps{}
libraries{
    commons{
        merge = true
    }
    core{
        merge = true
    }
    sonarqube{
        merge = true
    }
    merge = true
}
    
    
*/


steps {
  pre-build {
    validate
    generate
  }
  build {
    unit_test
    build
  }
  post-build{
    static_code_analysis
  }
}


libraries{
  merge = true 
  validation
  sonarqube
}
