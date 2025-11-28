import type {Gender} from '../enums/';

export type BookDto = {
    /**
     * 由 ObjectFetcher 定义的复杂图书 DTO
     */
    'EntityStyleController/COMPLEX_BOOK': {
        /**
         * The surrogate id of the current object,
         * auto-incrementing,
         * without specific business meaning
         */
        readonly id: number;
        /**
         * The name of current Book.
         * 
         * <p>This property forms a unique constraint together with
         * the {@code edition} property, which is {@code @Key} of Jimmer</p>
         */
        readonly name: string;
        /**
         * The edition of current Book.
         * 
         * <p>This property forms a unique constraint together with
         * the {@code name} property, which is {@code @Key} of Jimmer</p>
         */
        readonly edition: number;
        readonly price: number;
        /**
         * The bookstore to which the current book belongs,
         * representing a many-to-one association
         */
        readonly store?: {
            /**
             * The surrogate id of the current object,
             * auto-incrementing,
             * without specific business meaning
             */
            readonly id: number;
            /**
             * The name of current BookStore.
             * 
             * <p>This property forms a unique constraint,
             * which is {@code @Key} of Jimmer</p>
             */
            readonly name: string;
            readonly website?: string | undefined;
        } | undefined;
        /**
         * All authors who participated in writing
         * the current book,
         * representing a many-to-many association
         */
        readonly authors: ReadonlyArray<{
            /**
             * The surrogate id of the current object,
             * auto-incrementing,
             * without specific business meaning
             */
            readonly id: number;
            /**
             * The first name of current Author.
             * 
             * <p>This property forms a unique constraint together with
             * the {@code lastName} property, which is {@code @Key} of Jimmer</p>
             */
            readonly firstName: string;
            /**
             * The last name of current Book.
             * 
             * <p>This property forms a unique constraint together with
             * the {@code firstName} property, which is {@code @Key} of Jimmer</p>
             */
            readonly lastName: string;
            readonly gender: Gender;
        }>;
    }, 
    /**
     * 由 ObjectFetcher 定义的简单图书 DTO
     */
    'EntityStyleController/SIMPLE_BOOK': {
        /**
         * The surrogate id of the current object,
         * auto-incrementing,
         * without specific business meaning
         */
        readonly id: number;
        /**
         * The name of current Book.
         * 
         * <p>This property forms a unique constraint together with
         * the {@code edition} property, which is {@code @Key} of Jimmer</p>
         */
        readonly name: string;
    }
}
