# HaikunatorJAVA

[![Travis](https://img.shields.io/travis/Atrox/haikunatorjava.svg?style=flat-square)](https://travis-ci.org/Atrox/haikunatorjava)

Generate Heroku-like random names to use in your Java applications.

## Installation

To install Haikunator, do the following... *Soon*

## Usage

Haikunator is pretty simple.

```java
import at.atrox.haikunator;
import java.util.Map;

Map<String, Object> map = new HashMap<String, Object>();

// default usage
Haikunator.haikunate(map) // => "wispy-dust-1337"

// custom length (default=4)
map.put("tokenLength", 6);
Haikunator.haikunate(map) // => "patient-king-887265"

// use hex instead of numbers
map.put("tokenHex", true);
Haikunator.haikunate(map) // => "purple-breeze-98e1"

// use custom chars instead of numbers/hex
map.put("tokenChars", "HAIKUNATE")
Haikunator.haikunate(map) // => "summer-atom-IHEA"

// don't include a token
map.put("tokenLength", 0);
Haikunator.haikunate(map) // => "cold-wildflower"

// use a different delimiter
map.put("delimiter", ".");
Haikunator.haikunate(map) // => "restless.sea.7976"

// no token, space delimiter
map.put("tokenLength", 0);
map.put("delimiter", " ");
Haikunator.haikunate(map) // => "delicate haze"

// no token, empty delimiter
map.put("tokenLength", 0);
map.put("delimiter", "");
Haikunator.haikunate(map) // => "billowingleaf"
```

## Options

The following options are available:

```java
map.put("delimiter", "-");
map.put("tokenLength", 4);
map.put("tokenHex", true);
map.put("tokenChars", "0123456789");

Haikunator.haikunate(map)
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
- Dart: https://github.com/Atrox/haikunatordart
- Ruby: https://github.com/usmanbashir/haikunator
- Go: https://github.com/yelinaung/go-haikunator