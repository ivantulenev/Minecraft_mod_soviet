Stream.of(
Block.box(5.918750000000001, 0, 5.618749999999997, 10.51875, 3.1999999999999997, 10.018749999999995),
Block.box(7.918750000000001, 1.2000000000000002, 10.018749999999997, 8.443750000000001, 2.3999999999999995, 10.518749999999995),
Block.box(7.918750000000001, 1.8000000000000003, 10.518749999999995, 8.443750000000001, 2.5999999999999996, 11.018749999999994),
Block.box(7.918750000000001, 2.2000000000000006, 11.018749999999994, 8.443750000000001, 2.9, 11.418749999999992),
Block.box(6.218750000000002, 3.2, 5.818749999999996, 10.218750000000004, 3.7999999999999914, 9.818749999999996),
Block.box(8.068750000000001, 3.8000000000000007, 7.318749999999996, 8.343750000000002, 4.199999999999991, 8.318749999999996)
).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();