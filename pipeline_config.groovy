/*
  specify which libraries to load: 
    In the Governance Tier configuration file, 
    these should be configurations common across 
    all apps governed by this config. 
*/
libraries{
  merge = true 
  validation
  sonarqube
}

stages {
  pre-build {
     validate()
    generate()
  }
  build {
    unit_test()
    build()
  }
  post-build{
    static_code_analysis()
  }
}
