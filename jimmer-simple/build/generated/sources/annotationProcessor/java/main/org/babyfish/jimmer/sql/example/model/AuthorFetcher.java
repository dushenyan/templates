package org.babyfish.jimmer.sql.example.model;

import java.lang.Override;
import java.util.function.Consumer;
import org.babyfish.jimmer.internal.GeneratedBy;
import org.babyfish.jimmer.lang.NewChain;
import org.babyfish.jimmer.meta.ImmutableProp;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.babyfish.jimmer.sql.fetcher.FieldConfig;
import org.babyfish.jimmer.sql.fetcher.IdOnlyFetchType;
import org.babyfish.jimmer.sql.fetcher.ListFieldConfig;
import org.babyfish.jimmer.sql.fetcher.impl.FetcherImpl;
import org.babyfish.jimmer.sql.fetcher.spi.AbstractTypedFetcher;

@GeneratedBy(
        type = Author.class
)
public class AuthorFetcher extends AbstractTypedFetcher<Author, AuthorFetcher> {
    public static final AuthorFetcher $ = new AuthorFetcher(null);

    private AuthorFetcher(FetcherImpl<Author> base) {
        super(Author.class, base);
    }

    private AuthorFetcher(AuthorFetcher prev, ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        super(prev, prop, negative, idOnlyFetchType);
    }

    private AuthorFetcher(AuthorFetcher prev, ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        super(prev, prop, fieldConfig);
    }

    public static AuthorFetcher $from(Fetcher<Author> base) {
        return base instanceof AuthorFetcher ? 
        	(AuthorFetcher)base : 
        	new AuthorFetcher((FetcherImpl<Author>)base);
    }

    @NewChain
    public AuthorFetcher firstName() {
        return add("firstName");
    }

    @NewChain
    public AuthorFetcher firstName(boolean enabled) {
        return enabled ? add("firstName") : remove("firstName");
    }

    @NewChain
    public AuthorFetcher lastName() {
        return add("lastName");
    }

    @NewChain
    public AuthorFetcher lastName(boolean enabled) {
        return enabled ? add("lastName") : remove("lastName");
    }

    @NewChain
    public AuthorFetcher gender() {
        return add("gender");
    }

    @NewChain
    public AuthorFetcher gender(boolean enabled) {
        return enabled ? add("gender") : remove("gender");
    }

    @NewChain
    public AuthorFetcher books() {
        return add("books");
    }

    @NewChain
    public AuthorFetcher books(boolean enabled) {
        return enabled ? add("books") : remove("books");
    }

    @NewChain
    public AuthorFetcher books(Fetcher<Book> childFetcher) {
        return add("books", childFetcher);
    }

    @NewChain
    public AuthorFetcher books(Fetcher<Book> childFetcher,
            Consumer<ListFieldConfig<Book, BookTable>> fieldConfig) {
        return add("books", childFetcher, fieldConfig);
    }

    @Override
    protected AuthorFetcher createFetcher(ImmutableProp prop, boolean negative,
            IdOnlyFetchType idOnlyFetchType) {
        return new AuthorFetcher(this, prop, negative, idOnlyFetchType);
    }

    @Override
    protected AuthorFetcher createFetcher(ImmutableProp prop,
            FieldConfig<?, ? extends Table<?>> fieldConfig) {
        return new AuthorFetcher(this, prop, fieldConfig);
    }
}
