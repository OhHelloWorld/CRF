var path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');

const cssPlugin = new ExtractTextPlugin({
	filename: '[name].bundle.css',
});

module.exports = {
	entry: {
		vendor: [
			'jquery',
			'angular',
			'angular-ui-router',
			'lodash'
		],
		index: __dirname + 'index.js'
	},
	output: {
		filename: '[name].bundle.js',
		path: path.resolve(__dirname, 'dist')
	},
	module: {
		loaders: [{
			test: /\.js$/,
			exclude: /node_modules/,
			loaders: ['babel-loader']
		}, {
			test: /\.html$/,
			use: ['html-loader']
		}, {
			test: /\.css$/,
			use: cssPlugin.extract({
				use: 'css-loader',
				fallback: 'style-loader'
			}),
		}, {
			test: /\.(png)|(gif)|(jpg)$/,
			loader: 'url-loader?limit=50000'
		}, {
			test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
			use: 'url-loader?limit=10000&mimetype=application/font-woff'
		}, {
			test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
			use: 'file-loader'
		}]
	},
};