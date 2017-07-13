# POS
Prototipo de punto de venta desarrollado de manera modular con Maven.

El sistema esta compuesto de muchos modulos que hacen referencia a dos contextos de desarrollo.
El primer contexto es el mismo punto de venta (modulos pos-*) y el segundo contexto es la interacción con un sistema externo desde el punto de venta
(modulos erpint-*). De esta forma tenemos la arquitectura del sistema dividida en dos aplicaciones web comunicadas por medio de tecnologia REST.
