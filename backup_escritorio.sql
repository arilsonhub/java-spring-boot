--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.19
-- Dumped by pg_dump version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)

-- Started on 2019-10-24 11:09:10 -03

--
-- TOC entry 181 (class 1259 OID 16386)
-- Name: seq_cliente; Type: SEQUENCE; Schema: public; Owner: judice-v2
--

CREATE SEQUENCE public.seq_cliente
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16436)
-- Name: cliente; Type: TABLE; Schema: public; Owner: judice-v2
--

CREATE TABLE public.cliente (
    id bigint DEFAULT nextval('public.seq_cliente'::regclass) NOT NULL,
    nome character varying(100),
    cpf character(11),
    endereco character varying(100),
    bairro character varying(100),
    datacadastro timestamp without time zone,
    fone character varying(15),
    estado character(2),
    cidade character varying(100),
    ativo boolean
);

--
-- TOC entry 2101 (class 0 OID 16436)
-- Dependencies: 182
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: judice-v2
--

INSERT INTO public.cliente (id, nome, cpf, endereco, bairro, datacadastro, fone, estado, cidade, ativo) VALUES (1, 'Fernando', '50759247005', 'Rua Telopolis 13', 'Partenon', '2019-10-24 10:29:17.654', '33134516', 'RS', 'Porto Alegre', true);
INSERT INTO public.cliente (id, nome, cpf, endereco, bairro, datacadastro, fone, estado, cidade, ativo) VALUES (3, 'Cintia Rocha', '89169169098', 'Rua Villa', 'Villa Lobos', '2019-10-24 10:48:25.959', '33153616', 'RS', 'Gravataí', true);
INSERT INTO public.cliente (id, nome, cpf, endereco, bairro, datacadastro, fone, estado, cidade, ativo) VALUES (2, 'Alfredo Jaconi', '23321312050', 'Rua Jabileu Ferreira 10', 'Praia de Belas', '2019-10-24 10:31:34.609', '983376513', 'RS', 'Porto Alegre', true);


--
-- TOC entry 2111 (class 0 OID 0)
-- Dependencies: 181
-- Name: seq_cliente; Type: SEQUENCE SET; Schema: public; Owner: judice-v2
--

SELECT pg_catalog.setval('public.seq_cliente', 3, true);

-- Completed on 2019-10-24 11:09:11 -03

--
-- PostgreSQL database dump complete
--

