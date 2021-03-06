OBB Ranking [![Build Status](https://travis-ci.org/orionsbelt-battlegrounds/obb-ranking.svg?branch=master)](https://travis-ci.org/orionsbelt-battlegrounds/obb-ranking) [![Dependency Status](https://www.versioneye.com/user/projects/5452512630a8fe03a7000007/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5452512630a8fe03a7000007)
===========

Skill ranking for [Orion's Belt](https://github.com/orionsbelt-battlegrounds), based on [Glicko-2 Ranting System](http://www.glicko.net/glicko/glicko2.pdf/). The implementation was borrowed from [goochjs/glicko2](https://github.com/goochjs/glicko2). This project creates a _clojure_ wrapper around glicko2's java code.

There's a REST/JSON interface for this logic at [obb-rules-api](https://github.com/orionsbelt-battlegrounds/obb-rules-api).

### Instalation

[![Clojars Project](http://clojars.org/obb-ranking/latest-version.svg)](http://clojars.org/obb-ranking)

### Usage

```clojure
(obb-ranking.core/calculate {:rating 1500 :rd 50 :volatility 0.06}
                            {:rating 1200 :rd 350 :volatility 0.06})
;=> [{:rating 1500.20, :rd 51.05, :volatility 0.05}
;    {:rating 497.67, :rd 347.83, :volatility 0.05}]
```
