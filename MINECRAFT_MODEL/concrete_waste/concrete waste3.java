Stream.of(
Block.box(5.399999999999999, 0, 7, 13, 2, 11.9),
Block.box(9.999999999999998, 0, 2.1999999999999993, 13.2, 2, 7),
Block.box(11.999999999999998, 0, 4.899999999999999, 14.2, 2, 10.5),
Block.box(9.06653808871037, 2, 2.7126379674035483, 11.866538088710374, 4.000000000000002, 7.912637967403551)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();