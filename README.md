# HaikunatorJAVA

[![Build Status](https://img.shields.io/travis/Atrox/haikunatorjava.svg?style=flat-square)](https://travis-ci.org/Atrox/haikunatorjava)
[![Latest Version](https://maven-badges.herokuapp.com/maven-central/me.atrox.haikunator/Haikunator/badge.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/me.atrox.haikunator/Haikunator)

Generate Heroku-like random names to use in your Java applications.

## Installation

To install Haikunator add the following to your maven configuration
```xml
<dependency>
    <groupId>me.atrox.haikunator</groupId>
    <artifactId>Haikunator</artifactId>
    <version>1.2</version>
</dependency>
```
*For more examples how to add Haikunator to your project, [follow this link](https://maven-badges.herokuapp.com/maven-central/me.atrox.haikunator/Haikunator)*

## Usage

Haikunator is pretty simple.

```java
import me.atrox.haikunator;

// default usage
Haikunator haikunator = new HaikunatorBuilder().build();
haikunator.haikunate() // => "wispy-dust-1337"

// custom length (default=4)
Haikunator haikunator = new HaikunatorBuilder().setTokenLength(6).build();
haikunator.haikunate() // => "patient-king-887265"

// use hex instead of numbers
Haikunator haikunator = new HaikunatorBuilder().setTokenHex(true).build();
haikunator.haikunate() // => "purple-breeze-98e1"

// use custom chars instead of numbers/hex
Haikunator haikunator = new HaikunatorBuilder().setTokenChars("HAIKUNATE").build();
haikunator.haikunate() // => "summer-atom-IHEA"

// don't include a token
Haikunator haikunator = new HaikunatorBuilder().setTokenLength(0).build();
haikunator.haikunate() // => "cold-wildflower"

// use a different delimiter
Haikunator haikunator = new HaikunatorBuilder().setDelimiter(".").build();
haikunator.haikunate() // => "restless.sea.7976"

// no token, space delimiter
Haikunator haikunator = new HaikunatorBuilder().setTokenLength(0).setDelimiter(" ").build();
haikunator.haikunate() // => "delicate haze"

// no token, empty delimiter
Haikunator haikunator = new HaikunatorBuilder().setTokenLength(0).setDelimiter("").build();
haikunator.haikunate() // => "billowingleaf"
```

## Options

The following options are available:

```java
Haikunator haikunator = new HaikunatorBuilder()
                            .setDelimiter("-")
                            .setTokenLength(4)
                            .setTokenHex(false)
                            .setTokenChars("0123456789")
                            .build();
```
*If ```tokenHex``` is true, it overrides any tokens specified in ```tokenChars```*

## Contributing

Everyone is encouraged to help improve this project. Here are a few ways you can help:

- [Report bugs](https://github.com/Atrox/haikunatorjava/issues)
- Fix bugs and [submit pull requests](https://github.com/Atrox/haikunatorjava/pulls)
- Write, clarify, or fix documentation
- Suggest or add new features

## Other Languages

Haikunator is also available in other languages. Check them out:

- Python: https://github.com/Atrox/haikunatorpy
- Node: https://github.com/Atrox/haikunatorjs
- PHP: https://github.com/Atrox/haikunatorphp
- .NET: https://github.com/Atrox/haikunator.net
- Go: https://github.com/Atrox/haikunatorgo
- Dart: https://github.com/Atrox/haikunatordart
- Ruby: https://github.com/usmanbashir/haikunator
- Rust: https://github.com/nishanths/rust-haikunator
