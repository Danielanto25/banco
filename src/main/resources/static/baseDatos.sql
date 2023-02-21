
CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificacion` varchar(15) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `clave` int(11) NOT NULL,
  `id_estado` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `id_cuenta` bigint(20) NOT NULL,
  `numero_de_cuenta` bigint(20) NOT NULL,
  `saldo` float DEFAULT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  `id_estado` bigint(20) DEFAULT NULL,
  `id_tipo_cuenta` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `id_estado` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`id_estado`, `nombre`) VALUES
(1, 'True');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimientos`
--

CREATE TABLE `movimientos` (
  `id` bigint(20) NOT NULL,
  `fecha` date DEFAULT NULL,
  `saldo` float DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `id_cuenta` bigint(20) DEFAULT NULL,
  `id_tipo_movimiento` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_de_cuentas`
--

CREATE TABLE `tipos_de_cuentas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipos_de_cuentas`
--

INSERT INTO `tipos_de_cuentas` (`id`, `nombre`) VALUES
(1, 'AHORROS'),
(2, 'CORRIENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos_de_movimiento`
--

CREATE TABLE `tipos_de_movimiento` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipos_de_movimiento`
--

INSERT INTO `tipos_de_movimiento` (`id`, `nombre`) VALUES
(1, 'RETIRO'),
(2, 'DEPOSITO'),
(3, 'CREDITO');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_mvqpaay4xno9pnlalro0awadi` (`identificacion`),
  ADD KEY `FK_cliente_estado` (`id_estado`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`id_cuenta`),
  ADD UNIQUE KEY `UK_nedeb69bnr4mwgw78hg23f6q1` (`numero_de_cuenta`),
  ADD KEY `FK_cuenta_cliente` (`id_cliente`),
  ADD KEY `FK_cuenta_estado` (`id_estado`),
  ADD KEY `FK_cuenta_tipo_cuenta` (`id_tipo_cuenta`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`id_estado`);

--
-- Indices de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cuenta_movimiento` (`id_cuenta`),
  ADD KEY `fk_movimiento_tipo_movimiento` (`id_tipo_movimiento`);

--
-- Indices de la tabla `tipos_de_cuentas`
--
ALTER TABLE `tipos_de_cuentas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipos_de_movimiento`
--
ALTER TABLE `tipos_de_movimiento`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  MODIFY `id_cuenta` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estados`
--
ALTER TABLE `estados`
  MODIFY `id_estado` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `movimientos`
--
ALTER TABLE `movimientos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipos_de_cuentas`
--
ALTER TABLE `tipos_de_cuentas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipos_de_movimiento`
--
ALTER TABLE `tipos_de_movimiento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;
