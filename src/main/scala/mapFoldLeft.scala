def mapFoldLeft[Z, Y, X]: (Z => Y) => X => ((X, Y) => X) => List[Z] => X =
  `z=>y` => x => `(x,y)=>x` => zs => zs.map(`z=>y`).foldLeft(x)(`(x,y)=>x`)
