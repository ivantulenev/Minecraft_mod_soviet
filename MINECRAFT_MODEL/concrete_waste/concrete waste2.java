Stream.of(
Block.box(4.1, 0, 5.399999999999999, 9, 2, 13),
Block.box(9, 0, 9.999999999999998, 13.8, 2, 13.2),
Block.box(5.5, 0, 11.999999999999998, 11.100000000000001, 2, 14.2),
Block.box(8.087362032596449, 2, 9.06653808871037, 13.287362032596452, 4.000000000000002, 11.866538088710374)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();