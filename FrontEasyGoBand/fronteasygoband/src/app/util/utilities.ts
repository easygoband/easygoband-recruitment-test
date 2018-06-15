export function parserEpochDate(epoch: number): string {
  const locale = 'es';
  const options = {weekday: 'long', year: 'numeric', month: 'long', day: 'numeric'};
  const date = new Date(epoch * 1000);
  const hours = date.getHours();
  const minutes = '0' + date.getMinutes();
  const seconds = '0' + date.getSeconds();
  return date.toLocaleDateString(locale, options) + ' ' + hours + ':' + minutes.substr(-2) + ':' +
    seconds.substr(-2);
}
