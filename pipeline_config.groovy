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
    

// restrict individual repository Jenkinsfiles
allow_scm_jenkinsfile = false
// skip the default JTE checkout and do it explicitly
skip_default_checkout = false

// define application environment objects
application_environments{
    dev{
        long_name = "Development"
    }
    prod{
        long_name = "Production"
    }
}

template_methods{
    validate
    generate
    unit_test
    build  
    static_code_analysis
}  


*/



stages{
  pre_build{
    validate
  }
  build{    
    generate
    unit_test
    build
  }
  post_build{
    static_code_analysis
  }
}

libraries{
  merge = true 
  validation
  sonarqube
}
