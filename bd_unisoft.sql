-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15-Nov-2019 às 21:16
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_unisoft`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_admin`
--

CREATE TABLE `tb_admin` (
  `id_admin` int(11) NOT NULL,
  `nome_admin` varchar(100) NOT NULL,
  `usuario_admin` varchar(100) NOT NULL,
  `senha_admin` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_admin`
--

INSERT INTO `tb_admin` (`id_admin`, `nome_admin`, `usuario_admin`, `senha_admin`) VALUES
(1, 'Gerente', 'java', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_aluno`
--

CREATE TABLE `tb_aluno` (
  `id_aluno` int(11) NOT NULL,
  `matricula_aluno` varchar(100) NOT NULL,
  `nome_aluno` varchar(100) NOT NULL,
  `senha_aluno` varchar(100) NOT NULL,
  `cpf_aluno` varchar(100) NOT NULL,
  `data_nascimento_aluno` date NOT NULL,
  `telefone_aluno` varchar(100) NOT NULL,
  `id_curso_aluno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_aluno`
--

INSERT INTO `tb_aluno` (`id_aluno`, `matricula_aluno`, `nome_aluno`, `senha_aluno`, `cpf_aluno`, `data_nascimento_aluno`, `telefone_aluno`, `id_curso_aluno`) VALUES
(1, '123456', 'fulano', '123', '123.4566.789-12', '2019-11-06', '(85)91234-4568', 1),
(7, '1', '4', 'sddf', '123.456.789-45', '2019-11-01', '(85)12354-4568', 2),
(8, '222', 'ciclano', '123', '456.856.789-89', '2019-11-02', '(85)12356-5658', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_curso`
--

CREATE TABLE `tb_curso` (
  `id_curso` int(11) NOT NULL,
  `nome_curso` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_curso`
--

INSERT INTO `tb_curso` (`id_curso`, `nome_curso`) VALUES
(1, 'Engenharia de Computação'),
(2, 'Ciências da Computação');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_emprestimo`
--

CREATE TABLE `tb_emprestimo` (
  `id_emprestimo` int(11) NOT NULL,
  `data_inicio_emprestimo` date NOT NULL,
  `data_fim_emprestimo` date NOT NULL,
  `id_livro_emprestimo` int(11) NOT NULL,
  `id_aluno_emprestimo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_emprestimo`
--

INSERT INTO `tb_emprestimo` (`id_emprestimo`, `data_inicio_emprestimo`, `data_fim_emprestimo`, `id_livro_emprestimo`, `id_aluno_emprestimo`) VALUES
(1, '2019-11-01', '2019-11-15', 1, 1),
(2, '2019-11-04', '2019-11-22', 3, 1),
(3, '2019-11-25', '2019-11-30', 5, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_livro`
--

CREATE TABLE `tb_livro` (
  `id_livro` int(11) NOT NULL,
  `isbn_livro` varchar(100) NOT NULL,
  `titulo_livro` varchar(100) NOT NULL,
  `autor_livro` varchar(100) NOT NULL,
  `imagem_livro` varchar(100) NOT NULL,
  `descricao_livro` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tb_livro`
--

INSERT INTO `tb_livro` (`id_livro`, `isbn_livro`, `titulo_livro`, `autor_livro`, `imagem_livro`, `descricao_livro`) VALUES
(1, '123', 'As trança do rei careca', 'David', 'img.jpg', 'Isto é um livro.'),
(2, '7854', 'Poeira em alto mar', 'Jhoson', 'poeira.png', 'Isto é poeira'),
(3, '777', 'Era uma vez', 'Dr. Francisco', 'src/imgLivro/broom.png', 'Não sei nem quero saber'),
(4, '789', 'Queria um titulo', 'Antonio', 'src/imgLivro/calculator.png', 'Livrão'),
(5, '4655', 'nunca mais', 'Antonio', '', 'Livrão');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `tb_aluno`
--
ALTER TABLE `tb_aluno`
  ADD PRIMARY KEY (`id_aluno`),
  ADD KEY `key_curso` (`id_curso_aluno`);

--
-- Indexes for table `tb_curso`
--
ALTER TABLE `tb_curso`
  ADD PRIMARY KEY (`id_curso`);

--
-- Indexes for table `tb_emprestimo`
--
ALTER TABLE `tb_emprestimo`
  ADD PRIMARY KEY (`id_emprestimo`),
  ADD KEY `key_aluno` (`id_aluno_emprestimo`),
  ADD KEY `key_livro` (`id_livro_emprestimo`);

--
-- Indexes for table `tb_livro`
--
ALTER TABLE `tb_livro`
  ADD PRIMARY KEY (`id_livro`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_admin`
--
ALTER TABLE `tb_admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tb_aluno`
--
ALTER TABLE `tb_aluno`
  MODIFY `id_aluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tb_curso`
--
ALTER TABLE `tb_curso`
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tb_emprestimo`
--
ALTER TABLE `tb_emprestimo`
  MODIFY `id_emprestimo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tb_livro`
--
ALTER TABLE `tb_livro`
  MODIFY `id_livro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tb_aluno`
--
ALTER TABLE `tb_aluno`
  ADD CONSTRAINT `key_curso` FOREIGN KEY (`id_curso_aluno`) REFERENCES `tb_curso` (`id_curso`);

--
-- Limitadores para a tabela `tb_emprestimo`
--
ALTER TABLE `tb_emprestimo`
  ADD CONSTRAINT `key_aluno` FOREIGN KEY (`id_aluno_emprestimo`) REFERENCES `tb_aluno` (`id_aluno`),
  ADD CONSTRAINT `key_livro` FOREIGN KEY (`id_livro_emprestimo`) REFERENCES `tb_livro` (`id_livro`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
