package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exeptions.CommitExeption;
import br.com.fiap.tds.exeptions.VeiculoNotFoundExeption;

public interface VeiculoDao {
	void create(Veiculo veiculo);

	Veiculo read(int codigo)throws VeiculoNotFoundExeption;

	void update(Veiculo veiculo);

	void delete(int codigo) throws VeiculoNotFoundExeption;

	void commit() throws CommitExeption;

}
