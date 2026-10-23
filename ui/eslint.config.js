const eslint = require('@eslint/js');
const stylistic = require('@stylistic/eslint-plugin');
const angular = require('angular-eslint');
const tseslint = require('typescript-eslint');

module.exports = tseslint.config(
  {
    files: ['**/*.ts'],
    extends: [
      eslint.configs.recommended,
      ...tseslint.configs.recommended,
      ...angular.configs.tsRecommended,
    ],
    processor: angular.processInlineTemplates,
    plugins: {
      '@stylistic': stylistic,
    },
    rules: {
      '@angular-eslint/directive-selector': [
        'error',
        {
          type: 'attribute',
          prefix: 'app',
          style: 'camelCase',
        },
      ],
      '@angular-eslint/component-selector': [
        'error',
        {
          type: 'element',
          prefix: 'app',
          style: 'kebab-case',
        },
      ],
      '@angular-eslint/no-output-on-prefix': 'warn',
      '@angular-eslint/no-output-native': 'warn',
      '@angular-eslint/prefer-on-push-component-change-detection': 'off',
      '@typescript-eslint/adjacent-overload-signatures': 'warn',
      '@typescript-eslint/no-unused-vars': 'error',
      '@typescript-eslint/no-explicit-any': 'warn',
      '@typescript-eslint/explicit-member-accessibility': [
        'error',
        {
          accessibility: 'explicit',
        },
      ],
      '@typescript-eslint/no-empty-function': 'error',
      '@stylistic/quotes': [
        'error',
        'single',
        {
          avoidEscape: true,
          allowTemplateLiterals: 'always',
        },
      ],
      '@stylistic/max-len': [
        'error',
        {
          ignorePattern:
            '^import [^,]+ from |^export | implements | \\$localize`:@@[\\S\\s]+`| @functional\\(\\$\\{[\\S\\s]+\\}\\)',
          code: 140,
        },
      ],
      '@stylistic/comma-dangle': ['error', 'never'],
      '@stylistic/space-before-function-paren': 'off',
      'no-irregular-whitespace': ['error', { skipComments: true }],
    },
  },
  {
    files: ['**/*.html'],
    extends: [
      ...angular.configs.templateRecommended,
      ...angular.configs.templateAccessibility,
    ],
  },
);
