{ jdk }:

{
  packageOverrides = p: rec {
    java = p.${jdk};

    sbt = p.sbt.overrideAttrs (
      old: rec {
        version = "1.4.6";

        src = builtins.fetchurl {
          url    = "https://github.com/sbt/sbt/releases/download/v${version}/sbt-${version}.tgz";
          sha256 = "194xdz55cq4w7jlxl8df9vacil37jahimav620878q4ng67g59l6";
        };

        patchPhase = ''
          echo -java-home ${java} >> conf/sbtopts
        '';
      }
    );
  };
}
