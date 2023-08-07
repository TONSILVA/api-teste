package co.urban.api.teste.controller;

import co.urban.api.teste.produto.DadosAtualizacaoProduto;
import co.urban.api.teste.produto.DadosCadastroProduto;
import co.urban.api.teste.produto.Produto;
import co.urban.api.teste.produto.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroProduto dados){

        repository.save(new Produto(dados));
    }

    @GetMapping
    public Page<Produto> listar(Pageable paginacao){
    return repository.findAll(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProduto dados){
    var produto = repository.getReferenceById(dados.id());
    produto.atualizarDados(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id ){
    repository.deleteById(id);
    }

}
